#include <stdio.h>

main()
{
	int a;
	printf("������ �Է��Ͻÿ� : ");
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
	printf("\n") ;
	system("pause");
}
