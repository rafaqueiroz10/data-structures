#include <stdio.h>

typedef int Item;

void inverterValor(Item *a) {
    *a = -*a;
}

int main() {
    setvbuf(stdout, NULL, _IONBF, 0);

    // variável a
    int a = 1;
    printf("%d\n", a);
    
    // endereço de a
    printf("%p\n", &a);

    // ponteiro b aponta para o valor de 
    // endereço de a
    int* b = &a;
    printf("%d\n", *b);
    
    *b = a;
    printf("%d\n", *b);

    Item d = 10;
    Item* c = &d;

    // inverter o valor
    inverterValor(c);

    printf("%d\n", *c);

    return 0;
}