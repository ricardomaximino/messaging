export let getFakeDataContact = {
  chart: {
    type: 'spline'
  },

  title: {
      text: 'Creación de contacts semanal'
  },

  subtitle: {
      text: 'Fuente de datos: YUCON'
  },

  xAxis: {
    categories: ['Lunes', 'Martes', 'Meircoles', 'Jueves', 'Viernes', 'Sabado', 'Domingo']
  },

  yAxis: {
      title: {
          text: 'Numero de contactos creado'
      }
  },
  legend: {
      layout: 'vertical',
      align: 'right',
      verticalAlign: 'middle'
  },

  plotOptions: {
      series: {
          label: {
              connectorAllowed: false
          },
          pointStart: 0
      }
  },

  series: [{
      name: 'Marketing',
      data: [43934, 52503, 57177, 69658, 97031, 119931, 137133]
  } , {
      name: 'Field',
      data: [24916, 24064, 29742, 29851, 32490, 30282, 38121]
  }, {
      name: 'Internet',
      data: [11744, 17722, 16005, 19771, 20185, 24377, 32147]
  } ],

  responsive: {
      rules: [{
          condition: {
              maxWidth: 500
          },
          chartOptions: {
              legend: {
                  layout: 'horizontal',
                  align: 'center',
                  verticalAlign: 'bottom'
              }
          }
      }]
  }

};

export let getFakeDataContactEvent = {
  chart: {
    type: 'spline'
  },

  title: {
      text: 'Analisis de eventos del contacto'
  },

  subtitle: {
      text: 'fuente de datos: YUCON'
  },
  xAxis: {
    categories: ['09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00', '16:00', '17:00', '18:00', '19:00', '20:00']
  },

  yAxis: {
      title: {
          text: 'Numero de Eventos'
      }
  },
  legend: {
      layout: 'vertical',
      align: 'right',
      verticalAlign: 'middle'
  },

  plotOptions: {
      series: {
          label: {
              connectorAllowed: false
          },
          pointStart: 0
      }
  },

  series: [{
      name: 'creado',
      data: [43, 3, 77, 58, 31, 31, 33, 17, 34, 13, 77, 58]
  } , {
      name: 'guardado en DB',
      data: [16, 64, 42, 51, 90, 82, 21, 34, 90, 82, 21, 34]
  }, {
      name: 'Alterado',
      data: [44, 22, 5, 71, 85, 77, 47, 87, 5, 71, 85, 77]
  }, {
      name: 'Borrado',
      data: [null, null, 88, 69, 12, 52, 0, 27, null, 88, 69, 12]
  }, {
      name: 'fallo en guardar en DB',
      data: [8, 48, 9, 48, 89, 16, 74, 11, 8, 48, 8, 48]
  } ],

  responsive: {
      rules: [{
          condition: {
              maxWidth: 500
          },
          chartOptions: {
              legend: {
                  layout: 'horizontal',
                  align: 'center',
                  verticalAlign: 'bottom'
              }
          }
      }]
  }

};
