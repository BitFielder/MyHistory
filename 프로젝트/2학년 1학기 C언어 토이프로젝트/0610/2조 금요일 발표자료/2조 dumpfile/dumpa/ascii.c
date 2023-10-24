#include "ascii.h"
#include "DumpHexa.h"
#define myeof -1
int AsciiDump(FILE *i,FILE *o,char n){
	char addrbuf[bs], hexbuf[bs];
	int c;
	long l;
	for(l=addr;l<addr+n;l++){
		c=fgetc(i);
		sprintf(hexbuf,"%c ",c);
		strcat(retbuf,hexbuf);		// retbuf += hexbuf;
	}
	return c;
}
