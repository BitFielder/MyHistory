#include <stdio.h>

main()
{
	int a;
	printf("나이를 입력하시오 : ");
	scanf("%d",&a);
	if(a>=18)
	{
		printf("성인입니다\n");
		printf("입장하세요\n");
	}
	else
		printf("입장불가입니다\n");
	
	system("pause");
}
