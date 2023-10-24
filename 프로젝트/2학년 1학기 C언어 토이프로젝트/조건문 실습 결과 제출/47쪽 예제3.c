#include <stdio.h>

main()
{
	int a,b,c;
	printf("첫번째 값 : ");
	scanf("%d",&a);
	printf("사칙연산 부호 : ");
	scanf("%d",&b);
	printf("두번째 값 : ");
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
