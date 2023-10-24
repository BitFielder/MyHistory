#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "Openf.h"

int main(int ac, char **av) 
{
FILE *inf;
FILE *outf;
char inbuf[250];
char tbuf[250];
int strp=0;
	inf = Openf(inf,av[1],"r");
	outf = Openf(outf,av[2],"w");
	while( fgets(inbuf,BUF_SIZE,inf)!=0 )
	{
		for( strp=0;strp<strlen(inbuf)-1 ;strp++ )
		{
			if( (strp%4)==0 )
			{
				fprintf(outf,"\n%04X: ",strp);
			}
			fprintf(outf,"%02X ",inbuf[strp]);
		}
		fprintf(outf,"{");
		for( strp=0;strp<strlen(inbuf)-1 ;strp++ )
		{
			fprintf(outf,"%c",inbuf[strp]);
		}
		fprintf(outf,"}");
		fprintf(outf,"\n");
	}
	fclose(inf);
	fclose(outf);
	return 0;
}

