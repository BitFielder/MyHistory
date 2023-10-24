#include <stdio.h>
#include <stdlib.h>
/*
FILE *fopen(const char *fn, const char *fm){
	FILE *ft;
	return ft;
}*/

int main(int ac, char *av[]) {
	FILE *in;
	int crt;
	in = fopen(av[1], "r");
	/*for(crt=getch()	// initial condition, that is opening
	;(crt!='Z'-0x40) && (crt!='Y'-0x40)		// repeat condition, normal running
	;crt=getch()		// operation of the 1 turn, normal running
	)				// ending operation, closing
	{	
	putch(crt);
	printf("=%02X {%c}\n",crt,crt);
	} */
	
	if(in!=NULL){
		for(crt=fgetc(in); crt!=-1; crt=fgetc(in)){	
			printf("c=%02X {%c}\n",crt,crt);
			getch();
		}
		fclose(in);
	}
	return 0;
}