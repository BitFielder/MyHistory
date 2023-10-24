#include <stdio.h>
#include <stdlib.h>
#include "ln.h"

int main(int ac, char *av[]) {
	char state = 1;
	int ch,cc,oc;
	FILE *fin, *fout;
	
	fin;
	fout;
	if((fin = fopen("t.txt","r"))==NULL||(fout = fopen("tout.txt","w"))==NULL){
		printf("input file can not open!\n");
		return 1;
	}
	int i = 0;
	while((ch = fgetc(fin)) != -1){
		oc *= 2;
		if((ch&1)==1){
			oc++;
	}
	i++;
	if(i>8){
	printf("%02X{%c}\n",oc,oc);
	fprintf(fout,"%02X{%c}\n",oc,oc);
		i=0;
		oc=0;
	}
//	ln(ch,fout);
	}
	fclose(fin);
	fclose(fout);
	return 0;
}
