#include <stdio.h>

main()
{
	int a;
	scanf("%d",&a);
	if(a>0)
	{
		if(a%2==0)
			printf("¦���Դϴ�");
		else
			printf("Ȧ���Դϴ�");
	}
	else
		printf("����� �ƴմϴ�");
	
	System("pause");
}
