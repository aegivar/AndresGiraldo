       const sumar = (x,y) => {
        let promise, resultadoSuma = x + y;
        return promise = new Promise(resolve => resolve(resultadoSuma));
       };
        
        const restar = (x,y) => {
        let promise, resultadoSuma = x - y;
        return promise = new Promise(resolve => resolve(resultadoSuma));
        };
        const multiplicar = (x,y) => {
        let promise, resultadoSuma = x * y;
        return promise = new Promise(resolve => resolve(resultadoSuma));
        };

  let x = 5;
  let y = 3;
  async function calculadora(){
      try{
          const resultadoSuma = await sumar(x,y);
          console.log("EL resultado de las suma es :", resultadoSuma);
          
          const resultadoResta = await restar(x,y);
          console.log("EL resultado de la resta es :", resultadoResta);
          
          const resultadoMultiplicar = await multiplicar(x,y);
          console.log("EL resultado de la multiplicación es :", resultadoMultiplicar);
         
      } catch(e){
          throw "Se maneja el error: ${e}";
        }
  }
  calculadora();