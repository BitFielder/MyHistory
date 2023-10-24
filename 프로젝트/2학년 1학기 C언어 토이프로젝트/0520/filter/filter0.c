#include <stdio.h>
#include <stdlib.h>
#define ErrCI 1
#define ErrCO 2

int main(int ac, char **av) {
	
FILE *inf, *outf;
char *inbuf[250];
	
	if((inf= fopen(av[1],"r"))==NULL){
		printf("I Error!\n");
		exit(ErrCI);
	}
	if((outf)=fopen(av[2],"w")==NULL){
		printf("O Error!\n");
		exit(ErrCO);
	}
	while(fgets(inbuf,250,inf)){
		printf("{%s}",inbuf);
	}
	fclose(inf);
	fclose(outf);
	
/*	av[0] // %0
	av[1] // %1
	av[2] // %2
		ex) 아래와같이입력
		D: \wjdtlcjf1\0506>filter filtin.txt filtout.txt*/
	return 0;
}