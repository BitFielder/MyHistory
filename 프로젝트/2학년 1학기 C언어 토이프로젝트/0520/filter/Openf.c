#include <stdio.h>
#include <stdlib.h>
#include "Openf.h"
FILE *Openf(FILE *a, char *n, char *m){
	if((a=fopen(n, m))==NULL){
		printf("%s Error!\n",n);
		exit(ErrCI);
	}
	return a;
}
