#include <stdio.h>
#define MSB_MASK 0b10000000
#define BIT_SIZE 8
#define BIT_START 0

void Send(int ch,FILE *fout){
	int tc,i;
	tc = ch;
#if 1
	printf("tc = %02X {%c}",tc,tc);
	fprintf(fout,"tc = %02X {%c}",tc,tc);
#endif
	for(i=BIT_START;i<BIT_SIZE;i++){
		if((tc&MSB_MASK)==MSB_MASK){
			printf("1");
			fprintf(fout,"1");
		}else{
			printf("0");
			fprintf(fout,"0");
		}
		tc *= 2;
	}
	printf("\n");
	fprintf(fout,"\n");
//	fputc(ch,fout);
}
