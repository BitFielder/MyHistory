#include "hexa.h"
#include "DumpHexa.h"
#define myeof -1
int HexaDump(FILE *i,FILE *o,char n){
	char addrbuf[bs], hexbuf[bs];
	int c;
	long l;
	for(l=addr;l<addr+n;l++){
		c=fgetc(i);
		if(c==myeof)break;
		sprintf(hexbuf,"%02X ",c);
		strcat(retbuf,hexbuf);		// retbuf += hexbuf;
	}
	return c;
}
