#include <stdio.h>
#include <stdlib.h>
#include <string.h>
// char t4buf[250];
// char *hexadump;

//  hexadump=t4buf;
char *hexadump(char *t4,char *inbuf)
{
char t1[250];
int strp=0;
		strcpy(t4,"");
		for( strp=0;strp<strlen(inbuf)-1 ;strp++ )
		{
			if( (strp%4)==0 )
			{
				sprintf(t1,"\n%04X: ",strp);
				strcat(t4,t1);
			}
		}
	return t4; ////  hexadump=t4buf;
}


