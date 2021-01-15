import { ComponentFixture, TestBed } from '@angular/core/testing';

import { forum } from './forum.component';

describe('ForumComponent', () => {
  let component: forum;
  let fixture: ComponentFixture<forum>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ forum ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(forum);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
