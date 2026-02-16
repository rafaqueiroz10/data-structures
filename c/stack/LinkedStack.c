#include <stdio.h>
#include <stdlib.h>

typedef int Item;

typedef struct No {
    Item item;
    struct No* next;
} No;

typedef struct {
    No* top;
    int quantity;
} LinkedStack;

LinkedStack* newLinkedStack() {
    LinkedStack* stack = (LinkedStack*) malloc(sizeof(LinkedStack));
    stack->top = NULL;
    stack->quantity = 0;
    
    return stack;
}

int tamanho(LinkedStack* stack) {
    return stack->quantity;
}

int vazia(LinkedStack* stack) {
    return tamanho(stack) == 0;
}

void push(LinkedStack* stack, Item item) {
    No* newNo = (No*) malloc(sizeof(No));
    newNo->item = item;
    newNo->next = stack->top;
    stack->top = newNo;

    stack->quantity++;
}

Item pop(LinkedStack* stack) {
    if(vazia(stack))
        return -1;

    Item item = getTop(stack);
    
    No* top = stack->top;
    stack->top = stack->top->next;

    free(top);

    stack->quantity--;

    return item;
}

Item getTop(LinkedStack* stack) {
    if(vazia(stack))
       return -1;
       
    return stack->top->item;
}

void viewStack(LinkedStack* stack) {
    while(!vazia(stack))
        printf("%d\n", pop(stack));

    free(stack);
}

void freeStack(LinkedStack* stack) {
    while(!vazia(stack))
        pop(stack);

    free(stack);
}

int main() {
    LinkedStack* stack = newLinkedStack();

    push(stack, 10);
    printf("%d\n", getTop(stack));

    push(stack, 11);
    printf("%d\n", getTop(stack));

    push(stack, 12);
    printf("%d\n", getTop(stack));

    printf("%d removido\n", pop(stack));

    viewStack(stack);

    return 0;
}