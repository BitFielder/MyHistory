#include <stdio.h>
#include <stdlib.h>


/*
usage
c:>dumph infile_name outfile_nae [-l2}	// 2 byte per line
c:>dumph infile_name outfile_nae [-l4}	// 4 byte per line
c:>dumph infile_name outfile_nae [-l8}	// 8 byte per line
c:>dumph infile_name outfile_nae [-ln}	// n byte per line
outfile_name은 무조건 새로생성,
infile_name of outfile_name

*/

FILE *OpenFile(char *n,char *m);