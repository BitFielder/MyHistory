#include <stdio.h>

main()
{
	int a,b,c;
	printf("ù��° �� : ");
	scanf("%d",&a);
	printf("��Ģ���� ��ȣ : ");
	scanf("%d",&b);
	printf("�ι�° �� : ");
	scanf("%d",&c);
	if(b==1)
		printf("%d + %d = %d",a,c,a+c);
	if(b==2)
		printf("%d - %d = %d",a,c,a-c);
	if(b==3)
		printf("%d * %d = %d",a,c,a*c);
	if(b==4)
		printf("%d / %d = %d",a,c,a/c);
	printf("\n") ;
	system("pause");
}
