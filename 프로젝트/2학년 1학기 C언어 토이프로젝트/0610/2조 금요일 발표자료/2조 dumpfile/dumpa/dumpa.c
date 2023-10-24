#include <stdio.h>
#include <stdlib.h>

#include "openfiles.h"
#include "DumpHexa.h"

char retbuf[bs];
char retbuf2[bs];
long addr;

#define linedef 4
#define indef "inf.txt"
#define outdef "outf.txt"
int main(int ac, char *av[]) {
FILE *inf, *outf;
	int ll = 0;		//number of rows per column
	int t = 1;		//output type (ascii,hexa,all)
	
	switch(ac){
		case 1:		//default option (dumpa = dumpa inf.txt outf.txt -l4 -t1
			inf = OpenFile(indef,"r");			// input ready
			outf = OpenFile(outdef,"w");		// output ready
			ll = linedef;
			break;
		case 2:		//default option (dumpa (inputfile) = dumpa (inputfile) outf.txt -l4 -t1
			inf = OpenFile(av[1],"r");
			outf = OpenFile(outdef,"w");
			ll = linedef;
			break;
		case 3:		//default option (dumpa (inputfile) (outputfile) = dumpa (inputfile) (outputfile) -l4 -t1
			inf = OpenFile(av[1],"r");
			outf = OpenFile(av[2],"w");
			ll = linedef;
			break;
		case 4:		//default option (dumpa (inputfile) (outputfile) -l(value) = ... -l(value number) -t1
			inf = OpenFile(av[1],"r");
			outf = OpenFile(av[2],"w");
//			printf("av[3] = %s\n",av[3]);
			sscanf(av[3],"-l%d",&ll);
//			printf("ll = %d\n",ll);
			if(!ll) ll = linedef;
			break;
		case 5:		//custom option (dumpa (inputfile) (outputfile) -l(value number) -t(type number)
			inf = OpenFile(av[1],"r");
			outf = OpenFile(av[2],"w");
//											printf("av[3] = %s\n",av[3]);
			sscanf(av[3],"-l%d",&ll);
//											printf("ll = %d\n",ll);
			if(!ll) ll = linedef;
			sscanf(av[4],"-t%d",&t);
			break;
		default:	//syntax error?
			printf("Invalid command. Please enter in the correct format.\nEx : dumpa inf.txt outf.txt -l4 -t1");
	}
	
	addr = 0;
	DumpHexa(inf, outf, ll,t);
	
	fclose(inf);		//input close
	fclose(outf);		//output close
	return 0;
}
