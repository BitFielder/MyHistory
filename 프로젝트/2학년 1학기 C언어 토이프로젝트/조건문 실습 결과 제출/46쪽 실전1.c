#include <stdio.h>

main()
{
	int a;
	printf("정수를 입력하시오 : ");
	scanf("%d",&a);
	if(a>0)
	{
		if(a%2==0)
			printf("짝수입니다");
		else
			printf("홀수입니다");
	}
	else
		printf("양수가 아닙니다");
	printf("\n") ;
	system("pause");
}
