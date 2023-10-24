
#define STATE0 0
#define _DEBUG /*이거 정의되면 화면으ㅔ 동작과정이 표시됩니다.*/

#define DEBUG_PRT()	printf("i=%d in={%c} oc=%02X\n",i,ch,oc);	\
					printf("%02X{%c}\n",oc,oc);					\
					fprintf(fout,"%02X{%c}\n",oc,oc)

void filt(FILE *in,  FILE *out){
	int i = 0;
	int oc = 0;
	while((ch = fgetc(in)) != -1){
		switch(i){
			case STATE0:
				if(ch!='0'){ printf("start condition Error!");
				return(1);
				}i++;
				break;
			case 1:	case 2:	case 3:	case 4:	case 5:	case 6:	case 7:	case 8:
			oc = Atoi(oc,ch);i++;break;
			case 9:	
				if(ch!='1'){ printf("End Condition Error!\n");
				return(2);}
				#if defined(_DEBUG)
				DEBUG_PRT();
				#endif
				fprintf(out,"%c",oc);
				i = 0;
				oc = 0;
				break;
			default: break;
		}
	}
	if(i>=10){
#if defined(_DEBUG)
		DEBUG_PRT();
#endif 
		fprintf(out,"%c",oc);
	}
}