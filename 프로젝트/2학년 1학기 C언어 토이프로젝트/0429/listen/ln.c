#include <stdio.h>
#define MSB_MASK 0b10000000
#define BIT_SIZE 8
#define BIT_START 0

void ln(int ch,FILE *fout){
	int tc,i,oc,cc;
	tc = ch;
#if 0
	printf("tc = %02X {%c}",tc,tc);
	fprintf(fout,"tc = %02X {%c}",tc,tc);
#endif
#if 1
	printf("\n");
	fprintf(fout,"\n");
//	fputc(ch,fout);
#endif
}
