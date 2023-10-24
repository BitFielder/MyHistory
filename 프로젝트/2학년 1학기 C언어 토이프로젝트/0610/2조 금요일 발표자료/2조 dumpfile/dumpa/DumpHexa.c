#include "hexa.h"
#include "ascii.h"
#include "hexascii.h"
#include "DumpHexa.h"

#define myeof -1

void DumpHexa(FILE *i,FILE *o,char n,int t){
	char addrbuf[bs], hexbuf[bs];
	int c;
	long l = addr;

	for(; c!=myeof; addr +=n){
		strcpy(retbuf,"");
		strcpy(retbuf2,"");
		if(l%n==0) sprintf(addrbuf,"%08X:",addr);
		strcat(retbuf,addrbuf);
		
		switch(t){
			case 1:		//-t1, hexa
				c = HexaDump(i,o,n);
				break;
			case 2:		//-t2, ascii
				c = AsciiDump(i,o,n);
				break;
			case 3:		//-t3, allcount
				c = HexAsciiDump(i,o,n);                     
				break;
			default:	//other, compromise with hexa
				c = HexaDump(i,o,n);
		}
		
		/*			
		for(l=addr;l<addr+n;l++,c=fgetc(i)){		garbage code
			if(c==myeof)break;
			sprintf(hexbuf,"%c ",c);
			strcat(retbuf,hexbuf);
		}*/
		
		sprintf(hexbuf,"\n");
		strcat(retbuf,hexbuf);
		fprintf(o,"%s",retbuf);				//default output
		if(t==3) fprintf(o," + ascii:%s",retbuf2);	//if, type = ascii, hexa
	}
	return;
}
   
