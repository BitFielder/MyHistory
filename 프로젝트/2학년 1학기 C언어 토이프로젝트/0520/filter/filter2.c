#include <stdio.h>
#include <stdlib.h>
#include "Openf.h"

FILE *Openf(FILE *a, char *n, char *m);

int main(int ac, char **av){
	
FILE *inf, *outf;
char inbuf[250];
char temp[250];
	inf = Openf(inf,av[1],"r");
	outf =Openf(outf,av[2],"w");
	while(fgets(inbuf,bufSize,inf)!=0){
		printf("{%s}",inbuf);
		//strcpy(temp,"{");		strcat(tbuf,inbuf);		strcpy(temp,"}");
		//fputs(inbuf,outf);
		fprintf(outf,"theD{%s}",inbuf);
	}
	fclose(inf);
	fclose(outf);
	return 0;
}