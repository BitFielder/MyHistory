#include <stdio.h>
#define node 6

int number = node; // ����� ��
int INF = 100000; // ���Ѵ��� ��

// �׷����� ���� ���
int a[node][node] = {
    {0, 2, 5, 1, INF, INF},
    {2, 0, 3, 2, INF, INF},
    {5, 3, 0, 3, 1, 5},
    {1, 2, 3, 0, 1, INF},
    {INF, INF, 1, 1, 0, 2},
    {INF, INF, 5, INF, 2, 0}
};

bool v[node]; // �湮 ���θ� �����ϴ� �迭
int d[node]; // �ִ� �Ÿ��� �����ϴ� �迭

int getSmallIndex() {
    int min = INF;
    int index = 0;
    // ���� �湮���� �ʰ�, ���� �ּҰ����� �� ���� ���� ã�Ƽ� ��ȯ
    for (int i = 0; i < number; i++) {
        if (d[i] < min && !v[i]) {
            min = d[i];
            index = i;
        }
    }
    return index;
}

void dijkstra(int start) {
    // ���� ���κ����� �Ÿ��� �ʱ�ȭ
    for (int i = 0; i < number; i++) {
        d[i] = a[start][i];
    }
    v[start] = true; // ���� ��带 �湮 ǥ��
    for (int i = 0; i < number - 2; i++) {
        int current = getSmallIndex(); // ���� �湮���� ���� ��� �� �ּ� �Ÿ��� ���� ��� ����
        v[current] = true; // ������ ��带 �湮 ǥ��
        for (int j = 0; j < number; j++) {
            if (!v[j]) { // ���� �湮���� ���� ��忡 ���ؼ�
                // ��������� �Ÿ��� ������ ��带 ���ļ� ���� �Ÿ��� ���Ͽ� �� ª�� �Ÿ��� ������Ʈ
                if (d[current] + a[current][j] < d[j]) {
                    d[j] = d[current] + a[current][j];
                }
            }
        }
    }
}

int main(void) {
    dijkstra(0); // ���� ��带 0���� �����ϰ� ���ͽ�Ʈ�� �˰��� ����
    for (int i = 0; i < number; i++) {
        printf("%d ", d[i]); // ��� ���
    }
    return 0;
}
