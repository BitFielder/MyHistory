#include "hexascii.h"
#include "DumpHexa.h"
#define myeof -1
int HexAsciiDump(FILE *i,FILE *o,char n){
	char addrbuf[bs], hexbuf[bs];
	int a,c;
	long l;
		
	for(l=addr;l<addr+n;l++){
		c=fgetc(i);
		if(c==myeof)break;
		sprintf(hexbuf,"%02X ",c);
		strcat(retbuf,hexbuf);		// retbuf += hexbuf;
		sprintf(addrbuf,"%c  ",c);
		strcat(retbuf2,addrbuf);		// retbuf += hexbuf;
	}
		sprintf(addrbuf,"\n");
		strcat(retbuf2,addrbuf);		// retbuf += "\n";
	return c;
}
