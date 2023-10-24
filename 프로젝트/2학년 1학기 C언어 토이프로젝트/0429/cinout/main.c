#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{

FILE *fr, *fw;
int s_fw, n;
char *p_rbuf;
char rbuf[250], wbuf[250];

	fr = fopen("test.txt","r");
	fw = fopen("testout.txt","w");
	for(p_rbuf = fgets(rbuf,250,fr),n = 0;
	p_rbuf != 0;
	p_rbuf = fgets(rbuf,250,fr),n++){
		rbuf[strlen(rbuf)-1] = '\0';
		//fputs(rbuf,fr);
		fprintf(fw,"%s\n-----------------------------------\n",rbuf);
		fprintf(fw,"%05d : {%s}\n-----------------------------------\n",n,rbuf);
	}
	fclose(fr);
	fclose(fw);
	return 0;
}