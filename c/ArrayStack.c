#include <stdio.h>
#include <stdlib.h>

typedef int Item;

typedef struct {
    int top, capacity;
    Item *items;
    int quantity;
} ArrayStack;

ArrayStack* newArrayStack(int initialSize) {
    ArrayStack *stack = (ArrayStack*) malloc(sizeof(ArrayStack));

    if(stack == NULL)
        return NULL;

    stack->items = (Item*) malloc(initialSize * sizeof(Item));
    
    if(stack->items == NULL)
        return NULL;

    stack->capacity = initialSize;
    stack->top = -1;
    stack->quantity = 0;

    return stack;
}

int size(ArrayStack* stack) {
    return stack->quantity;
}

int empty(ArrayStack* stack) {
    return size(stack) == 0;
}

Item* resize(ArrayStack* stack) {
    stack->capacity *= 2;
    Item* newItems = (Item*) malloc(stack->capacity * sizeof(Item));
    
    for(int i = 0; i < size(stack); i++) 
        newItems[i] = stack->items[i];

    free(stack->items);

    return newItems;
}

void push(ArrayStack* stack, Item item) {
    if(stack->top == stack->capacity-1)
        stack->items = resize(stack);
    
    stack->top++;
    stack->items[stack->top] = item;

    stack->quantity++;
}

Item pop(ArrayStack* stack) {
    if(empty(stack))
        return NULL;
    
    Item item = stack->items[stack->top--];
    stack->quantity--;
    
    return item;
}

Item getTop(ArrayStack* stack) {
    if(empty(stack)) 
        return NULL;
    
    return stack->items[stack->top];
}