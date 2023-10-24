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
		for(strp = 0;strp <strlen(inbuf);strp++){
			if((strp%4)==0){
				fprintf(outf,"\n%04X: ",strp);
			}
			fprintf(outf,"%02X ",inbuf[strp]);
		}
		fprintf(outf,"{");
		for(strp = 0;strp <strlen(inbuf);strp++){
			fprintf(outf,"%c",inbuf[strp]);
		}
		fprintf(outf,"}\n");
	}
	fclose(inf);
	fclose(outf);
	return 0;
}