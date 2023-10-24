#include <stdio.h>
#include <stdlib.h>
// string -> str -> s
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int pcst;
	FILE *fo = fopen("testout.c","w");
	pcst=fputs("윾",fo);
	printf("fputc = %d\n",pcst);
	fclose(fo);
	return 0;
}