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
char t1buf[250];
char t2buf[250];
char t3buf[250];
int strp=0;
	inf = Openf(inf,av[1],"r");
	outf = Openf(outf,av[2],"w");
	while( fgets(inbuf,BUF_SIZE,inf)!=0 )
	{
		strcpy(t2buf,"");
		for( strp=0;strp<strlen(inbuf)-1 ;strp++ )
		{
			if( (strp%4)==0 )
			{
				sprintf(t1buf,"\n%04X: ",strp);
				strcat(t2buf,t1buf);
			}
			sprintf(t1buf,"%02X ",inbuf[strp]);
			strcat(t2buf,t1buf);
		}
		sprintf(t1buf,"{");
		strcpy(t3buf,t1buf);
		for( strp=0;strp<strlen(inbuf)-1 ;strp++ )
		{
			sprintf(t1buf,"%c",inbuf[strp]);
			strcat(t3buf,t1buf);
		}
		sprintf(t1buf,"}\n");
		strcat(t3buf,t1buf);
		
		fprintf(outf,"%s",t2buf);
	}
	fclose(inf);
	fclose(outf);
	return 0;
}

