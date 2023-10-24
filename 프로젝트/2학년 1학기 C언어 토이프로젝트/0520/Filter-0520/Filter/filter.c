#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "Openf.h"
#include "dumps.h"

int main(int ac, char **av) 
{
FILE *inf;
FILE *outf;
char inbuf[250];
char tbuf[250];
char t1buf[250];
char t2buf[250];
char t3buf[250];
char t4buf[250];
int strp=0;
char *myp1;
char *myp2;
char *myp3;

	inf = Openf(inf,av[1],"r");
	outf = Openf(outf,av[2],"w");
	while( fgets(inbuf,BUF_SIZE,inf)!=0 )
	{

		myp1=hexadump(t4buf,inbuf);

		strcpy(t2buf,"");
		for( strp=0;strp<strlen(inbuf)-1 ;strp++ )
		{
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

		sprintf(t1buf,"}");
		strcat(t3buf,t1buf);

//		fprintf(outf,"[%s]\n",t4buf);
		fprintf(outf,"%s",myp1);
		fprintf(outf,"%s",t2buf);
		fprintf(outf,"%s\n",t3buf);
	}
	fclose(inf);
	fclose(outf);
	return 0;
}

