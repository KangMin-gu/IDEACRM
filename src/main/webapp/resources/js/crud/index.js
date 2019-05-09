

//   상담유형
$.ajax({
    url: "/main/chart/recp",
    method: "POST",
    dataType: "json",
    data : {},
    cache: false,
    success: function (recpData) {
        var recpArr = new Array();
        recpArr[0] = recpData.normal;
        recpArr[1] = recpData.compli;
        recpArr[2] = recpData.quality;
        recpArr[3] = recpData.afterService;
        recpArr[4] = recpData.center;
        recpArr[5] = recpData.store;
        recpArr[6] = recpData.complain;
        recpArr[7] = recpData.management;

        var ctx = document.getElementById("receptChart");
        var receptChart = new Chart(ctx, {
            type: 'horizontalBar',
            data: {
                labels: ['일반', '칭찬', '품질', 'as', '콜센터', '매장', '불만', '관리'],
                datasets: [{
                    label: '# 접수유형',
                    data: recpArr,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)',
                        'rgba(255, 159, 64, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)',
                        'rgba(255, 159, 64, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                }
            }
        });

    },
    error: function (request, status, error) {
    }
});



// 제품유형


var ctx2 = document.getElementById("productChart");
var productChart = new Chart(ctx2, {
    type: 'bar',
    data: {
        labels: ['1월', '2월', '3월', '4월', '5월'],
        datasets:[

            {
                label: "폴리코사놀 10mg(30정)",
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                borderColor:  'rgba(255, 99, 132, 1)',
                data: [15,5,21,4,11]
            },
            {
                label: "폴리코사놀 5mg(30정)",
                backgroundColor: 'rgba(54, 162, 235, 0.2)',
                borderColor: 'rgba(54, 162, 235, 1)',
                pointBackgroundColor: "rgba(26,179,148,1)",
                data: [19,3,4,33,8]
            },
            {
                label: "폴리코사놀 10mg(75정)",
                backgroundColor: 'rgba(255, 206, 86, 0.2)',
                borderColor: 'rgba(255, 206, 86, 1)',
                pointBackgroundColor: "rgba(26,179,148,1)",
                data: [21,22,7,13,26]
            },
            {
                label: "폴리코사놀 10mg(180정)",
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                pointBackgroundColor: "rgba(26,179,148,1)",
                data: [18,9,8,3,21]
            },
            {
                label: "폴리코사놀 10mg(180정)",
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                pointBackgroundColor: "rgba(26,179,148,1)",
                data: [6,34,15,9,27]
            }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});