#include <stdio.h>
#include <stdlib.h>

typedef int Item;

typedef struct {
    Item* itens;
    int quantity, top, capacity;
} ArrayStack;

ArrayStack* newArrayStack(int capacity) {
    ArrayStack* stack = (ArrayStack*) malloc(sizeof(ArrayStack));

    if(stack == NULL)
        return NULL;
    
    stack->itens = (Item*) malloc(capacity * sizeof(Item));

    if(stack->itens == NULL)
        return NULL;

    stack->quantity = 0;
    stack->top = -1;
    stack->capacity = capacity;
    
    return stack;
}

int size(ArrayStack* stack) {
    return stack->quantity;
}

int empty(ArrayStack* stack) {
    return size(stack) == 0;
}

ArrayStack* resize(ArrayStack* stack) {
    int newCapacity = stack->capacity * 2;
    Item* itens = realloc(stack->itens, newCapacity * sizeof(Item));

    if(itens == NULL)
        return NULL;

    stack->itens = itens;    
    stack->capacity = newCapacity;

    return stack;
}

int full(ArrayStack* stack) {
    return stack->capacity == stack->quantity;
}

Item getTop(ArrayStack* stack) {
    if(empty(stack))
       return -1;

    return stack->itens[stack->top];
}

void push(ArrayStack* stack, Item item) {
    if(full(stack)) 
        stack = resize(stack);

    stack->itens[++stack->top] = item;
    stack->quantity++;
}

Item pop(ArrayStack* stack) {
    if(empty(stack))
        return -1;

    Item item = getTop(stack);
    stack->top--;
    stack->quantity--;

    return item;
}

void viewStack(ArrayStack* stack) {
    printf("Itens da lista:");
    while(!empty(stack))
        printf(" %d", pop(stack));

    printf("\n");
}

void freeStack(ArrayStack* stack) {
    while(!empty(stack))
        pop(stack);

    free(stack->itens);
    free(stack);
}

int main() {
    ArrayStack* stack = newArrayStack(5);

    push(stack, 10);
    printf("%d\n", getTop(stack));

    push(stack, 11);
    printf("%d\n", getTop(stack));

    push(stack, 12);
    printf("%d\n", getTop(stack));

    printf("%d removido\n", pop(stack));

    viewStack(stack);

    freeStack(stack);

    return 0;
}