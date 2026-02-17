#include <stdio.h>
#include <stdlib.h>

#define NENHUM_ITEM -1

typedef int Item;

typedef struct {
    Item* itens;
    int capacity, quantity, first, last;
} ArrayCircularQueue;

ArrayCircularQueue* newArrayCircularQueue(int capacity) {
    ArrayCircularQueue* queue = (ArrayCircularQueue*) malloc(sizeof(ArrayCircularQueue));
    Item* itens = (Item*) malloc(capacity * sizeof(Item));

    if(itens == NULL)
        return NULL;

    queue->itens = itens;
    queue->capacity = capacity;
    queue->quantity = 0;
    queue->first = -1;
    queue->last = -1;

    return queue;
}

int size(ArrayCircularQueue* queue) {
    return queue->quantity;
}

int empty(ArrayCircularQueue* queue) {
    return size(queue) == 0;
}

ArrayCircularQueue* resize(ArrayCircularQueue* queue) {
    int newCapacity = queue->capacity * 2;
    Item* itens = realloc(queue->itens, newCapacity * sizeof(Item));

    if(itens == NULL)
        return NULL;
    
    if(queue->first > queue->last) {
        int j = 0;

        for(int i = queue->first; i < queue->capacity; i++)
            itens[j++] = queue->itens[i];
        
        for(int i = 0; i < queue->last; i++)
            itens[j++] = queue->itens[i];

    }

    queue->itens = itens;
    queue->capacity = newCapacity;
    queue->first = 0;
    queue->last = queue->quantity;

    return queue;
}

int full(ArrayCircularQueue* queue) {
    return queue->capacity == queue->quantity;
}

void enqueue(ArrayCircularQueue* queue, Item item) {
    if(full(queue))
        queue = resize(queue);
    
    if(queue == NULL)
        return;

    if(empty(queue)) 
        queue->first = queue->last = 0;

    queue->itens[queue->last++] = item;

    if(queue->last == queue->capacity)
        queue->last = 0;

    queue->quantity++;
}

Item getFirst(ArrayCircularQueue* queue) {
    if(empty(queue))
        return NENHUM_ITEM;

    return queue->itens[queue->first];
}

Item dequeue(ArrayCircularQueue* queue) {
    if(empty(queue))
        return NENHUM_ITEM;

    Item first = getFirst(queue);
    queue->first++;

    if(queue->first == queue->capacity)
        queue->first = 0;
    
    queue->quantity--;

    return first;
}

void viewQueue(ArrayCircularQueue* queue) {
    if(empty(queue)) {
        printf("Lista vazia!!\n");
        return;
    }

    printf("Itens da lista:");
    while(!empty(queue))
        printf(" %d", dequeue(queue));

    printf("\n");
}

void freeQueue(ArrayCircularQueue* queue) {
    free(queue->itens);
    free(queue);
}

void test1(ArrayCircularQueue* queue) {
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

    printf("%d removido\n", dequeue(queue));

    printf("%d removido\n", dequeue(queue));

    printf("%d removido\n", dequeue(queue));

    enqueue(queue, 15);
    printf("Primeiro item: %d\n", getFirst(queue));

    printf("%d removido\n", dequeue(queue));

    viewQueue(queue);
}

void test2(ArrayCircularQueue* queue) {
    for(int i = 0; i < 100000; i++) {
        enqueue(queue, i);
        if(i % 2 == 0)
            dequeue(queue);
    }

    viewQueue(queue);
}

void test3(ArrayCircularQueue* queue) {
    enqueue(queue, 1);
    enqueue(queue, 2);
    enqueue(queue, 3);
    enqueue(queue, 4);
    enqueue(queue, 5);

    dequeue(queue); 
    dequeue(queue); 
    dequeue(queue); 

    enqueue(queue, 6);
    enqueue(queue, 7);
    enqueue(queue, 8);  

    viewQueue(queue);
}

void test4(ArrayCircularQueue* queue) {
    enqueue(queue, 10);
    enqueue(queue, 11);
    enqueue(queue, 12);
    enqueue(queue, 13);

    dequeue(queue);
    dequeue(queue);

    enqueue(queue, 14);
    enqueue(queue, 15); 

    viewQueue(queue);
}

void test5(ArrayCircularQueue* queue) {
    for(int i = 1; i <= 20; i++)
        enqueue(queue, i);

    viewQueue(queue);
}

void test6(ArrayCircularQueue* queue) {
    for(int i = 0; i < 50; i++) {
        enqueue(queue, i);
        dequeue(queue);
    }
}

void test7(ArrayCircularQueue* queue) {
    while(!empty(queue))
        dequeue(queue);

    enqueue(queue, 100);
    enqueue(queue, 200);

    viewQueue(queue);
}

int main() {
    ArrayCircularQueue* queue = newArrayCircularQueue(5);

    test1(queue);
    test2(queue);
    test3(queue);
    test4(queue);
    test5(queue);
    test6(queue);
    test7(queue);

    freeQueue(queue);

    return 0;
}