#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Openf.h"
#include "dumps.h"  // myp1 구문 가져오기 
#include "yycmyp2.h"
#include "myp3.h"

int main(int ac, char **av){
	
FILE *inf, *outf;
char inbuf[250];
char temp[250], t1buf[250], t2buf[250], t3buf[250], t4buf[250]; // 템프 선언 
int strp=0;
char *myp1;
char *myp2;		//아무나 이거 맡아줄사람 1명 
char *myp3;		//아무나 이거 맡아줄사람 1명 

	inf = Openf(inf,av[1],"r");		outf= Openf(outf,av[2],"w");
	while(fgets(inbuf,bufSize,inf)!=0){
		
		// myp1 구문 (dumps파일로 dumps.c로 코딩, dumps.h로 헤더파일 읽기
		myp1 = hexadump(t4buf,inbuf);
		
		// myp2 구문 
		myp2 = yycmyp2(t2buf,inbuf);
		// myp2 구문 끝 
		
		// myp3 구문 
		myp3 = hyhmyp3(t3buf,inbuf);
		// myp3구문 끝 
		
		
//		fprintf(outf,"[%s]\n",t4buf);	무시하셈 
		fprintf(outf,"{%s}",myp1); //myp1 결과만 출력하기 0000 0004 이런거 
		fprintf(outf,"%s",myp2); 
		fprintf(outf,"%s",myp3);
	}
	fclose(inf);
	fclose(outf);
	return 0;
}
