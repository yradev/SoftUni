function solve(object){

if(object.dizziness){
    object.levelOfHydrated += object.weight*0.1*object.experience;
}

return object;
};

solve({ weight: 80,
    experience: 1,
    levelOfHydrated: 0,
    dizziness: true }
  );

  solve({ weight: 120,
    experience: 20,
    levelOfHydrated: 200,
    dizziness: true }
  );