#include <stdio.h>
#include <stdlib.h>
#include "sn.h"
//void Send(int ch,FILE *fout);


int main(int ac, char *av[]) {
	char state = 1;
	int ch,cc;
	FILE *fin, *fout;
	
	fin;
	fout;
	if((fin = fopen("t.txt","r"))==NULL||(fout = fopen("tout.txt","w"))==NULL){
		printf("input file can not open!\n");
		return 1;
	}
	while((ch = fgetc(fin)) != -1){ 
		Send(ch,fout);
	}
	fclose(fin);
	fclose(fout);
	return 0;
}
