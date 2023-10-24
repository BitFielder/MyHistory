#include <stdio.h>
#include <stdlib.h>

int Atoi(int i,char c){
	i *= 2;
	if(c>'1'||c<'0') return -1; 
	i += c&1;
	return i;
}