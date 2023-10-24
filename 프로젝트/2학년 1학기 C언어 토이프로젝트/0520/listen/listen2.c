#include <stdio.h>
#include <stdlib.h>
#include "ln.h"
#define DEBUG_PRT()	printf("i=%d in={%c} oc=%02X\n",i,ch,oc);	\
					printf("%02X{%c}\n",oc,oc);					\
					fprintf(fout,"%02X{%c}\n",oc,oc)
int main(int ac, char *av[]) {
	char state = 1;
	int i,ch,cc,oc;
	FILE *fin, *fout;
	
	if((fin = fopen("tout.txt","r"))==NULL||(fout = fopen("tt.txt","w"))==NULL){
		printf("input file can not open!\n");
		return 1;
	}
	i = 0;
#define _DEBUG
	while((ch = fgetc(fin)) != -1){
		if(i!=0 &&i!=9 && i!=10){
		oc *= 2;
		if(ch=='1') oc+=1;
		}
		else{
			if(i==0&& ch!='0') return(1); 
			if(i==9&& ch!='1') return(2); 
		}
		if(i>=10){
#if defined(_DEBUG)
		DEBUG_PRT();
#endif
			fprintf(fout,"%c",oc);
			i=0;
			oc=0;
		}
		else{
#if defined(_DEBUG)
			printf("i=%d in = {%c} oc=%02X\n",i,ch,oc);
#endif
		}
		i++;
//		listen(ch,fout);
	}
	if(i>=10){
#if defined(_DEBUG)
		DEBUG_PRT();
#endif 
		fprintf(fout,"%c",oc);
	}
	fclose(fin);
	fclose(fout);
	return 0;
}
