#include <stdio.h>
#include <stdlib.h>

#define NENHUM_ITEM -1

typedef int Item;

typedef struct No {
    Item item;
    struct No* next;
} No;

typedef struct {
    No* first;
    No* last;
    int quantity;
} LinkedQueue;

LinkedQueue* newLinkedQueue() {
    LinkedQueue* queue = (LinkedQueue*) malloc(sizeof(LinkedQueue));

    if(queue == NULL)
        return NULL;

    queue->first = NULL;
    queue->last = NULL;
    queue->quantity = 0;

    return queue;
}

int size(LinkedQueue* queue) {
    return queue->quantity;
}

int empty(LinkedQueue* queue) {
    return size(queue) == 0;
}

void enqueue(LinkedQueue* queue, Item item) {
    No* no = (No*) malloc(sizeof(No));
    if(no == NULL)
        return;
        
    no->item = item;
    no->next = NULL;

    if(empty(queue)) 
        queue->first = no;
    else 
        queue->last->next = no;

    queue->last = no;
    queue->quantity++;
}

Item getFirst(LinkedQueue* queue) {
    if(empty(queue))
        return NENHUM_ITEM;

    return queue->first->item;
}

Item dequeue(LinkedQueue* queue) {
    if(empty(queue))
        return NENHUM_ITEM;
    
    Item item = getFirst(queue);

    No* first = queue->first;
    queue->first = queue->first->next;
    queue->quantity--;

    if(empty(queue))
        queue->last = NULL;

    free(first);

    return item;
}

void viewQueue(LinkedQueue* queue) {
    if(empty(queue)) {
        printf("Fila vazia!!\n");
        return;
    }

    printf("Itens da fila:");
    while(!empty(queue))
        printf(" %d", dequeue(queue));
    
    printf("\n");
}

void freeQueue(LinkedQueue* queue) {
    while(!empty(queue))
        dequeue(queue);
    
    free(queue);
}

int main() {
    LinkedQueue* queue = newLinkedQueue();

    enqueue(queue, 10);
    printf("Primeiro item: %d\n", getFirst(queue));

    enqueue(queue, 11);
    printf("Primeiro item: %d\n", getFirst(queue));

    enqueue(queue, 12);
    printf("Primeiro item: %d\n", getFirst(queue));

    printf("%d removido\n", dequeue(queue));

    viewQueue(queue);

    freeQueue(queue);

    return 0;
}