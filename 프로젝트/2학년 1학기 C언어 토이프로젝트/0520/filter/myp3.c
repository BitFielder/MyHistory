#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *hyhmyp3(char *t3, char *inbuf){
	char t1[250];
	int strp=0;
		sprintf(t1,"{");
		strcpy(t3,t1);
		for(strp = 0;strp <strlen(inbuf)-1;strp++){
			sprintf(t1,"%c",inbuf[strp]);
			strcat(t3,t1);
		}
		sprintf(t1,"}\n");
		strcat(t3,t1);
	return t3;
}
