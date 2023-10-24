#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define bs 250

extern long addr;
extern char retbuf[bs];
extern char retbuf2[bs];
void DumpHexa(FILE *i,FILE *o,char n,int t);