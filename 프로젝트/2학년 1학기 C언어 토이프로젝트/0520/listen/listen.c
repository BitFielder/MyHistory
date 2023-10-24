#include <stdio.h>
#include <stdlib.h>
#include "ln.h"
#include "atoi.h"

int filt(FILE *in,  FILE *out);

int main(int ac, char *av[]) {
	char state = 1;
	int ch,cc;
	FILE *fin, *fout;
	
	if((fin = fopen("tout.txt","r"))==NULL||(fout = fopen("tt.txt","w"))==NULL){
		printf("input file can not open!\n");
		return 1;
	}
	
	filt(fin, fout);
	fclose(fin);
	fclose(fout);
	return 0;
}
