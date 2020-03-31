for i in range(1,10):
    if i%2!=0:
        for j in range(1,10):
            if i*j<=50:
                print(f'{i*j:3d}',end=' ')
            else:
                continue
        print()
