#include <stdio.h>
#include <stdlib.h>

#define NENHUM_ITEM -1

typedef int Item;

typedef struct {
    Item* itens;
    int capacity, quantity, first, last;
} ArrayQueue;

ArrayQueue* newArrayQueue(int capacity) {
    ArrayQueue* queue = (ArrayQueue*) malloc(sizeof(ArrayQueue));
    Item* itens = (Item*) malloc(capacity * sizeof(Item));

    queue->itens = itens;
    queue->capacity = capacity;
    queue->quantity = 0;
    queue->first = -1;
    queue->last = -1;

    return queue;
}

int size(ArrayQueue* queue) {
    return queue->quantity;
}

int empty(ArrayQueue* queue) {
    return size(queue) == 0;
}

ArrayQueue* resize(ArrayQueue* queue) {
    int newCapacity = queue->capacity * 2;
    Item* itens = realloc(queue->itens, newCapacity * sizeof(Item));

    if(itens == NULL)
        return NULL;

    queue->itens = itens;    
    queue->capacity = newCapacity;

    return queue;
}

int full(ArrayQueue* queue) {
    return queue->capacity == queue->quantity;
}

void enqueue(ArrayQueue* queue, Item item) {
    ArrayQueue* copiaQueue = queue;
    
    if(full(queue))
        copiaQueue = resize(queue);
    
    if(copiaQueue == NULL)
        return;

    queue = copiaQueue;

    if(empty(queue)) 
        queue->first = queue->last = 0;

    queue->itens[queue->last++] = item;

    queue->quantity++;
}

Item getFirst(ArrayQueue* queue) {
    if(empty(queue))
        return NENHUM_ITEM;

    return queue->itens[queue->first];
}

Item dequeue(ArrayQueue* queue) {
    if(empty(queue))
        return NENHUM_ITEM;

    Item first = getFirst(queue);
    queue->quantity--;
    queue->first++;

    if(empty(queue))
        queue->first = queue->last = -1;

    return first;
}

void viewQueue(ArrayQueue* queue) {
    printf("Itens da lista:");
    while(!empty(queue))
        printf(" %d", dequeue(queue));

    printf("\n");
}

void freeQueue(ArrayQueue* queue) {
    free(queue->itens);
    free(queue);
}

int main() {
    ArrayQueue* queue = newArrayQueue(5);

    enqueue(queue, 10);
    printf("Primeiro item: %d\n", getFirst(queue));

    enqueue(queue, 11);
    printf("Primeiro item: %d\n", getFirst(queue));

    enqueue(queue, 12);
    printf("Primeiro item: %d\n", getFirst(queue));

    enqueue(queue, 13);
    printf("Primeiro item: %d\n", getFirst(queue));

    enqueue(queue, 14);
    printf("Primeiro item: %d\n", getFirst(queue));

    enqueue(queue, 15);
    printf("Primeiro item: %d\n", getFirst(queue));

    printf("%d removido\n", dequeue(queue));

    viewQueue(queue);

    freeQueue(queue);

    return 0;
}