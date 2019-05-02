
var ctx = document.getElementById("receiptChart");
var receiptChart = new Chart(ctx, {
    type: 'horizontalBar',
    data: {
        labels: ['일반', '칭찬', '품질', 'A/S', '콜센', '매장','불만','관리'],
        datasets: [{
            label: '# 접수유형',
            data: [90, 20, 5, 6, 1, 2, 1, 5],
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


var ctx2 = document.getElementById("productChart");
var productChart = new Chart(ctx2, {
    type: 'bar',
    data: {
        labels: ['1월', '2월', '3월', '4월', '5월'],
        datasets: [
            {
                label: "폴리코사놀 10mg(30정)",
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                borderColor:  'rgba(255, 99, 132, 1)',
                data: [65, 79, 70, 72, 80]
            },
            {
                label: "폴리코사놀 5mg(30정)",
                backgroundColor: 'rgba(54, 162, 235, 0.2)',
                borderColor: 'rgba(54, 162, 235, 1)',
                pointBackgroundColor: "rgba(26,179,148,1)",
                data: [28, 38, 40, 29, 50]
            },
            {
                label: "폴리코사놀 10mg(75정)",
                backgroundColor: 'rgba(255, 206, 86, 0.2)',
                borderColor: 'rgba(255, 206, 86, 1)',
                pointBackgroundColor: "rgba(26,179,148,1)",
                data: [38, 28, 10, 21, 15]
            },
            {
                label: "폴리코사놀 10mg(180정)",
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                pointBackgroundColor: "rgba(26,179,148,1)",
                data: [58, 38, 40, 49, 36]
            },
            {
                label: "폴리코사놀 in 오메가",
                backgroundColor: 'rgba(153, 102, 255, 0.2)',
                borderColor: 'rgba(153, 102, 255, 1)',
                pointBackgroundColor: "rgba(26,179,148,1)",
                data: [18, 20, 31, 30, 26]
            }
        ]
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
