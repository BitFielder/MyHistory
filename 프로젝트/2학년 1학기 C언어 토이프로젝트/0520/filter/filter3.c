#include <stdio.h>
#include <stdlib.h>
#include "Openf.h"

FILE *Openf(FILE *a, char *n, char *m);

int main(int ac, char **av){
	
FILE *inf, *outf;
char inbuf[250];
char temp[250];
int strp=0;

	inf = Openf(inf,av[1],"r");
	outf =Openf(outf,av[2],"w");
	while(fgets(inbuf,bufSize,inf)!=0){
		fprintf(outf,"%s",inbuf);
		for(strp = 0,fprintf(outf,"%04X: ",strp);strp <strlen(inbuf);strp++){
			fprintf(outf,"%02X",inbuf[strp]);
			if((strp%4)==0){
				fprintf(outf,"\n%04X: ",strp);
			}
			fprintf(outf,"%02X ",inbuf[strp]);
		}
		fprintf(outf,"\n");
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