#include <stdio.h>

main()
{
	int a;
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
	
	System("pause");
}
