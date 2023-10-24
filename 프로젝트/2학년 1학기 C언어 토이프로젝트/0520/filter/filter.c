#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Openf.h"
#include "dumps.h"  // myp1 ���� �������� 
#include "yycmyp2.h"
#include "myp3.h"

int main(int ac, char **av){
	
FILE *inf, *outf;
char inbuf[250];
char temp[250], t1buf[250], t2buf[250], t3buf[250], t4buf[250]; // ���� ���� 
int strp=0;
char *myp1;
char *myp2;		//�ƹ��� �̰� �þ��ٻ�� 1�� 
char *myp3;		//�ƹ��� �̰� �þ��ٻ�� 1�� 

	inf = Openf(inf,av[1],"r");		outf= Openf(outf,av[2],"w");
	while(fgets(inbuf,bufSize,inf)!=0){
		
		// myp1 ���� (dumps���Ϸ� dumps.c�� �ڵ�, dumps.h�� ������� �б�
		myp1 = hexadump(t4buf,inbuf);
		
		// myp2 ���� 
		myp2 = yycmyp2(t2buf,inbuf);
		// myp2 ���� �� 
		
		// myp3 ���� 
		myp3 = hyhmyp3(t3buf,inbuf);
		// myp3���� �� 
		
		
//		fprintf(outf,"[%s]\n",t4buf);	�����ϼ� 
		fprintf(outf,"{%s}",myp1); //myp1 ����� ����ϱ� 0000 0004 �̷��� 
		fprintf(outf,"%s",myp2); 
		fprintf(outf,"%s",myp3);
	}
	fclose(inf);
	fclose(outf);
	return 0;
}
