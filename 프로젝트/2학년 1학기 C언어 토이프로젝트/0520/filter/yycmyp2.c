#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *yycmyp2(char *t2, char *inbuf){
		char t1[250];
		int strp=0;
		strcpy(t2,"");
		for(strp = 0;strp <strlen(inbuf)-1;strp++){
			sprintf(t1,"%02X ",inbuf[strp]);
			strcat(t2,t1);
		}
	return t2;
}
