#include <stdio.h>
#define node 6

int number = node; // 노드의 수
int INF = 100000; // 무한대의 값

// 그래프의 인접 행렬
int a[node][node] = {
    {0, 2, 5, 1, INF, INF},
    {2, 0, 3, 2, INF, INF},
    {5, 3, 0, 3, 1, 5},
    {1, 2, 3, 0, 1, INF},
    {INF, INF, 1, 1, 0, 2},
    {INF, INF, 5, INF, 2, 0}
};

bool v[node]; // 방문 여부를 저장하는 배열
int d[node]; // 최단 거리를 저장하는 배열

int getSmallIndex() {
    int min = INF;
    int index = 0;
    // 아직 방문하지 않고, 현재 최소값보다 더 작은 값을 찾아서 반환
    for (int i = 0; i < number; i++) {
        if (d[i] < min && !v[i]) {
            min = d[i];
            index = i;
        }
    }
    return index;
}

void dijkstra(int start) {
    // 시작 노드로부터의 거리를 초기화
    for (int i = 0; i < number; i++) {
        d[i] = a[start][i];
    }
    v[start] = true; // 시작 노드를 방문 표시
    for (int i = 0; i < number - 2; i++) {
        int current = getSmallIndex(); // 아직 방문하지 않은 노드 중 최소 거리를 가진 노드 선택
        v[current] = true; // 선택한 노드를 방문 표시
        for (int j = 0; j < number; j++) {
            if (!v[j]) { // 아직 방문하지 않은 노드에 대해서
                // 현재까지의 거리와 선택한 노드를 거쳐서 가는 거리를 비교하여 더 짧은 거리로 업데이트
                if (d[current] + a[current][j] < d[j]) {
                    d[j] = d[current] + a[current][j];
                }
            }
        }
    }
}

int main(void) {
    dijkstra(0); // 시작 노드를 0으로 설정하고 다익스트라 알고리즘 수행
    for (int i = 0; i < number; i++) {
        printf("%d ", d[i]); // 결과 출력
    }
    return 0;
}
