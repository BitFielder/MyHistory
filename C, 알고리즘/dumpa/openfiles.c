#include "openfiles.h"

FILE *OpenFile(char *n,char *m){
FILE *f;
	if((f=fopen(n,m))==NULL){
		fprintf(stderr,"\"%s\" File cannot Open!\n",n);
		exit(1);
	}
	return f;
}